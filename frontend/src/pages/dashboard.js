import React, { Fragment, Component } from 'react';
import { Row, Col } from 'reactstrap';
import axios from "axios";

import './dashboard.css';
import SimpleDeckglMap from '../components/deckgl/simplemap';
import SideBar from '../components/Menu/SideBar'

export default class Dashboard extends Component {
    state = {
        data: []
    }

    componentDidMount() {
        const url = `https://api.themoviedb.org/3/movie/now_playing?api_key=126293cbe36ad88482598ec4e7595380`
        axios.get(url)
            .then(res => {
                const results = res.data.results;
                this.setState({data: results})
            })
    }

    render() {
        return (
            <Fragment >
                <div style={{ background: '#f8f8f8' }}>
                    <Row className="mb-1">
                        <Col>
                            <h1>
                                <span className="header">Dashboard</span>
                            </h1>
                            <div className="separator" />
                        </Col>
                    </Row>
                    <Row style={{ justifyContent: 'center', display: 'flex', flexDirection: 'row' }}>
                        <Col xs='4'>
                            <SideBar />
                        </Col>
                        <Col xs='6' style={{ position: "relative", width: '100%', height: '1000px', padding: '4rem', marginLeft: '2rem' }}>
                            <SimpleDeckglMap />
                        </Col>
                    </Row>
                </div>
            </Fragment >
        )
    }
}