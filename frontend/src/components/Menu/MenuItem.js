import React, { Component } from 'react';
import { Card, CardTitle, CardBody } from 'reactstrap';

class MenuItem extends Component {
    render() {
        return (
            <Card style={{ borderBottomColor: '#29CBF3'}} onClick={() => console.log('click')}>
                <CardTitle style={{ fontSize: '12px' }}>
                    {this.props.title}
                </CardTitle>
                <CardBody>
                    {this.props.description}
                </CardBody>
            </Card>
        );
    }
}

export default MenuItem