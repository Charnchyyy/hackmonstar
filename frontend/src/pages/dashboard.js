import React, { Fragment, Component } from 'react';
import { Row, Col, Card, CardTitle, CardBody } from 'reactstrap';
import axios from "axios";
import PerfectScrollbar from "react-perfect-scrollbar";

import MenuItem from '../components/Menu/MenuItem'
import './dashboard.css';
import SimpleDeckglMap from '../components/deckgl/simplemap';
// import SideBar from '../components/Menu/SideBar'

export default class Dashboard extends Component {
    state = {
        activeData: [],
        active: 1,
        data1: [],
        data2: [],
        data3: [],
        color1: {},
        color2: {},
        color3: {},
    }

    componentDidMount() {
        const url = `https://api.themoviedb.org/3/movie/now_playing?api_key=126293cbe36ad88482598ec4e7595380`
        axios.get(url)
            .then(res => {
                const results = res.data.results;
                this.setState({ data1: results })
            })
        this.getTheRest()
    }

    async getTheRest() {
        const url2 = 'https://api.themoviedb.org/3/movie/now_playing?api_key=126293cbe36ad88482598ec4e7595380'
        const url3 = 'https://api.themoviedb.org/3/movie/now_playing?api_key=126293cbe36ad88482598ec4e7595380'
        await axios.get(url2).then(res => {
            const results = res.data.results;
            this.setState({ data2: results })
        })
        await axios.get(url3).then(res => {
            const results = res.data.results;
            this.setState({ data3: results })
        })
    }

    dataSelector(selection) {
        if (selection === '1') {
            this.setState({ 
                activeData: this.state.data1, 
                color1: { borderColor: '#5DADE5', borderWidth: '2px', borderStyle: 'solid' },
                color2: {},
                color3: {}
            })
        }
        else if (selection === '2') {
            this.setState({ 
                activeData: this.state.data2, 
                color1: {},
                color2: { borderColor: '#5DADE5', borderWidth: '2px', borderStyle: 'solid' },
                color3: {}
            })
        }
        else if (selection === '3') {
            this.setState({ 
                activeData: this.state.data3, active: 3,
                color1: {},
                color2: {},
                color3: { borderColor: '#5DADE5', borderWidth: '2px', borderStyle: 'solid' }
            })
        }
    }

    render() {
        return (
            <Fragment >
                <div>
                    <Row className="card">
                        <Col>
                            <h1 style={{margin: '1rem'}}>
                                <span style={{marginLeft: '2rem'}}>Dashboard</span>
                            </h1>
                            {/* <div className="separator" /> */}
                        </Col>
                    </Row>
                    <Row style={{ justifyContent: 'center', display: 'flex', flexDirection: 'row' }}>
                        <Col xs='6' style={{marginLeft: '1rem'}}>
                            <div className="side-nav-container">
                                <PerfectScrollbar
                                    option={{ suppressScrollX: true, wheelPropagation: false }}
                                >
                                    <Card style={this.state.color1} onClick={() => this.dataSelector('1')}>
                                        <CardTitle style={{ fontSize: '12px' }}>
                                            Overall Density
                                        </CardTitle>
                                    </Card>

                                    <Card style={this.state.color2} onClick={() => this.dataSelector('2')}>
                                        <CardTitle style={{ fontSize: '12px' }}>
                                            High Demand for Taxi
                                        </CardTitle>
                                    </Card>

                                    <Card style={this.state.color3} onClick={() => this.dataSelector('3')}>
                                        <CardTitle style={{ fontSize: '12px' }}>
                                            Most Congest Area
                                        </CardTitle>
                                    </Card>

                                </PerfectScrollbar>
                            </div>
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