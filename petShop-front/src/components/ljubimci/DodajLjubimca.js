import { useCallback, useEffect, useState } from "react";
import { Button, Col, Form, Row } from "react-bootstrap";
import { useNavigate } from "react-router-dom";
import Axios from "../../apis/Axios";

const NoviLjubimac = () => {

    const zadatak = {
        id: -1,
        ime: '',
        starost: '',
        pol: '',
        tezina: '',
        opis: '',
        kategorijaId: -1

    }
    const [kategorije, setKategorije] = useState([])
    const [noviLjubimac, setNoviLjubimac] = useState(zadatak)
    var navigate = useNavigate()


    const dodaj = () => {

        const dto = {
            ime: noviLjubimac.ime,
            starost: noviLjubimac.starost,
            pol: noviLjubimac.pol,
            tezina: noviLjubimac.tezina,
            opis: noviLjubimac.opis,
            kategorijaId: noviLjubimac.kategorijaId
        }

        Axios.post('/ljubimci', dto)
            .then(res => {
                console.log(res)
                navigate('/ljubimci')
            })
            .catch(err => {
                console.log(err)
                alert("Doslo je do greske, pokusajte novi unos!")
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
        getAll2()
      }, [])

    const valueInputChanged = (e) => {

        let input = e.target;
        let name = input.name;
        let value = input.value;

        noviLjubimac[name] = value;
        setNoviLjubimac(noviLjubimac);
    }

    const rednerAll2 = () => {
        return kategorije.map((kategorija) => {
        return(<option key={kategorija.id} value={kategorija.id}>{kategorija.naziv}</option>)
        })

    }

    return(
        <div>
            <Col>
          <br/><br/>
          <Row><h1>Dodavanje novog kucnog ljubimca</h1></Row>
          <br/>
          <Row>
            <Col></Col>
            <Col xs="12" sm="10" md="8">
              <Form>
                <Form.Label htmlFor="ime">Ime</Form.Label>
                <Form.Control id="ime" placeholder="ime ljubimca" type="text" name="ime" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="starost">Starost</Form.Label>
                <Form.Control id="starost" placeholder="starost (broj meseci)" name="starost" type="text" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label>Pol</Form.Label>
                    <Form.Select name='pol' onChange={(e) => valueInputChanged(e)}>
                        <option value={""}>--izaberi pol--</option>
                        <option value={"muski"}>Muski</option>
                        <option value={"zenski"}>Zenski</option>
                    </Form.Select>
                <Form.Label htmlFor="tezina">Tezina</Form.Label>
                <Form.Control id="tezina" placeholder="tezina (kg)" min={0} name="tezina" type="number" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="opis">Opis</Form.Label>
                <Form.Control id="opis" placeholder="opis ljubimca" type="text" name="opis" onChange={(e) => valueInputChanged(e)}/>
                <Form.Label htmlFor="kategorijaId">Kategorija</Form.Label>
                <Form.Select name='kategorijaId' onChange={(e) => valueInputChanged(e)}>
                        <option value={""}>--izaberi kategoriju--</option>
                        {rednerAll2()}
                    </Form.Select>
                <br/>
                <Button className="btn btn-primary" onClick={() => dodaj()}>Dodaj ljubimca</Button>
              </Form>
            </Col>
            <Col></Col>
          </Row>
        </Col>
        </div>
    );


}

export default NoviLjubimac;