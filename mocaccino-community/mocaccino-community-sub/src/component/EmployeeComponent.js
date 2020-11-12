/**
 *
 * Copyright 2020 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

import React, {Component} from 'react';
import EmployeeView from '../view/EmployeeView';

export default class EmployeeComponent extends Component {

    constructor(props) {
        super(props);

        this.state = {
            employees: []
        };
    }

    async componentDidMount() {
        await fetch('http://localhost:8000/rest/employees')
            .then(response=>response.setHeader('Access-Control-Allow-Methods', 'GET').json())
            .then((data)=>{this.setState({employees: data})})
            .catch(console.log)
    }

    render() {
        return (
            <div className="container">
                <EmployeeView employees={this.state.employees}/>
            </div>
        )
    }
}
