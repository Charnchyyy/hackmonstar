import React, { Fragment } from 'react'
import { Row, Col, Card, CardBody, CardTitle } from 'reactstrap';
import './dashboard.css';
import SimpleMap from '../components/googlemap/map'

export default function Dashboard() {
    return (
        <Fragment>
            <Row className="mb-1">
                <Col>
                    <h1>
                        <span className="header">Dashboard</span>
                    </h1>
                    <div className="separator" />
                </Col>
            </Row>
            <Row style={{ display: 'flex', flexDirection: 'row', justifyContent: 'center' }}>
                <SimpleMap />
            </Row>
        </Fragment>
    )
}