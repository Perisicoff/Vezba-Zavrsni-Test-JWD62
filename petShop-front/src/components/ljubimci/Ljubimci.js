import React, { useCallback, useEffect, useState } from 'react'
import { Button, Col, Collapse, Form, FormCheck, Row, Table } from 'react-bootstrap';
import { useNavigate } from "react-router-dom";
import Axios from '../../apis/Axios';
import {IsLoggedIn} from '../../service/auth'
import '../../index.css'
import { Rola } from '../../service/auth'

const Ljubimci = (props) => {

    var navigate = useNavigate()
    const [ljubimci, setLjubimci] = useState([])
    const [kategorije, setKategorije] = useState([])
    const [pageNo, setPageNo] = useState(0)
    const [totalPage, setTotalPage] = useState(0)
    const [isChecked, setIsChecked] = useState(false);
    const [searchParams, setSearchParams] = useState({
      pol: "",
      opis: "",
      kategorijaId: ""

    })
  
    const getAll = useCallback((nextPage) => {
        const config = {
          params: {
            pol: searchParams.pol,
            opis: searchParams.opis,
            kategorijaId: searchParams.kategorijaId,
            pageNo: nextPage
          }
        }
        Axios.get('/ljubimci', config)
        .then(res => {
          console.log(res)
          setLjubimci(res.data)
          setPageNo(nextPage)
          setTotalPage(res.headers["total-pages"])
        })
        .catch(err => {
          console.log(err)
        })
    }, [])

    const udomi = (ljubimacId) => {

        Axios.post('/ljubimci/' + ljubimacId)
            .then(res => {
                console.log(res)
                alert("Uspesno ste udomili kucnog ljubimca!")
                window.location.reload()
            })
            .catch(err => {
                console.log(err)
                alert("Kucni ljubimac je vec udomljen!")
            })
    }

    const vakcinacija = (ljubimacId) => {

        Axios.put('/ljubimci/' + ljubimacId + '/vakcinacija')
            .then(res => {
                console.log(res)
                window.location.reload()
            })
            .catch(err => {
                console.log(err)
                alert("Dogodila se greska!")
            })
    }

    const getAll2 = useCallback(() => {
      Axios.get('/kategorije')
      .then(res => {
        console.log(res)
        setKategorije(res.data)
      })
      .catch(err => {
        console.log(err)
      })
    }, [])
  
    useEffect(() => {
      getAll(pageNo)
      getAll2()
    }, [])

    const goToAdd = () => {
      navigate('/ljubimac/add')
    }

    const delte = (ljubimacId) => {
      const confirmDelete = window.confirm("Da li ste sigurni da zelite da obrisete ovaj film?");
      if (confirmDelete) {
        Axios.delete('/ljubimci/' + ljubimacId)
        .then(res => {
          console.log(res)
          setLjubimci((ljubimci)=>ljubimci.filter(ljubimac => ljubimac.id !== ljubimacId))
        })
        .catch(err => {
          console.log(err)
        })
      } else {
        navigate('/ljubimci')
      }
    }

    const rednerAll = () => {
      return ljubimci.map((ljubimac) => {
        return(
          <tr key={ljubimac.id}>
            <td>{ljubimac.ime}</td>
            <td>{ljubimac.starost}</td>
            {IsLoggedIn() && Rola() == "admin" ? <td><FormCheck type="checkbox" checked={ljubimac.vakcinisan}  onChange={() => vakcinacija(ljubimac.id)}></FormCheck></td>:
            <td>{ljubimac.vakcinisan?<p>Vakcinisan</p>:<p>Nije vakcinisan</p>}</td>}
            <td>{ljubimac.pol}</td>
            <td>{ljubimac.tezina}</td>
            <td>{ljubimac.opis}</td>
            <td>{ljubimac.nazivKategorije}</td>
            {IsLoggedIn() && Rola() == "korisnik"&& ljubimac.vakcinisan && <td><Button className="btn btn-info btn-sm" onClick={() => udomi(ljubimac.id)}>Udomi</Button></td>}
            {IsLoggedIn() && Rola() == "admin" && <td><Button className="btn btn-danger btn-sm" onClick={() => delte(ljubimac.id)}>Ukloni</Button></td>}
          </tr>
        )
      })

    }

    const rednerAll2 = () => {
      return kategorije.map((kategorija) => {
        return(<option key={kategorija.id} value={kategorija.id}>{kategorija.naziv}</option>)
      })

    }

    const serchValue = (event) => {
      let name = event.target.name
      let value = event.target.value
      
      searchParams[name] = value
      setSearchParams(searchParams)
      getAll(0)
    }
    
    return (
      <div>
        <Row className="justify-content-center">
        <Col  xs="12" sm="10" md="8">
          <br/><br/>
          <Row><h1>Kucni ljubimci</h1></Row>
            <Form.Group style={{marginTop:35}}>
                <Form.Check type="checkbox" label="Show search form" onClick={(event) => setIsChecked(event.target.checked)}/>
            </Form.Group>
            <Collapse in={isChecked}>
            <Form style={{marginTop:10}}>
                <Form.Group>
                <Form.Label>Pol</Form.Label>
                    <Form.Select name='pol' onChange={serchValue}>
                        <option value={""}>--izaberi pol--</option>
                        <option value={"muski"}>Muski</option>
                        <option value={"zenski"}>Zenski</option>
                    </Form.Select>
                </Form.Group>
                <Form.Group>
                <Form.Label>Kategorija</Form.Label>
                    <Form.Select name='kategorijaId' onChange={serchValue}>
                        <option value={""}>--izaberi kategoriju--</option>
                        {rednerAll2()}
                    </Form.Select>
                </Form.Group>
                <Form.Group>
                    <Form.Label>Opis</Form.Label>
                    <Form.Control type='text' placeholder="opis ljubimca" name='opis' onChange={serchValue} ></Form.Control><br/>
                </Form.Group>
            </Form>
            </Collapse>
          <Row>
            <Col>
              <Table>
                <thead>
                  <tr>
                    <th>Ime</th>
                    <th>Starost</th>
                    <th>Vakcinisan</th>
                    <th>Pol</th>
                    <th>Tezina</th>
                    <th>Opis</th>
                    <th>Kategorija</th>
                    <th></th>
                  </tr>
                </thead>
                <tbody>
                  {rednerAll()}
                </tbody>
              </Table>
            </Col>
          </Row>
          <Row>{IsLoggedIn() && Rola() == "admin" && <Button className="btn btn-primary btn-sm" onClick={() => goToAdd()}>Novi ljubimac</Button>}</Row>
          <br/>
          <div style={{ display: 'flex', justifyContent: 'center' }}>
            <Button className="btn btn-light btn-sm" disabled={pageNo==0} onClick={() => getAll(pageNo-1)}>{'❮'}</Button>
            <span style={{ margin: '10px' }}> {pageNo + 1} </span> 
           <Button className="btn btn-light btn-sm" disabled={pageNo==totalPage-1 || ljubimci.length === 0} onClick={() => getAll(pageNo+1)}>{'❯'}</Button>
          </div>
        </Col>
        </Row>
      </div>
    );
  }

export default Ljubimci;