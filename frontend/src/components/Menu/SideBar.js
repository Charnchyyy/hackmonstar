import React, { Component } from 'react';
import PerfectScrollbar from "react-perfect-scrollbar";

import MenuItem from './MenuItem'
import "./SideBar.css"

class SideBar extends Component {
    render() {
        return (
            <div className="side-nav-container">
                <PerfectScrollbar
                    option={{ suppressScrollX: true, wheelPropagation: false }}
                >
                    <MenuItem title='Overall Density'/>
                    <MenuItem title='High Desity Area for Taxi'/>
                    <MenuItem title='Most Congested Area'/>
                </PerfectScrollbar>
            </div>
                );
            }
        }
        
export default SideBar