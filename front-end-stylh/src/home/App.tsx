import React from 'react';
import './App.css';
import 'react-flexr/styles.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import MyNavbar from "./mynavbar/MyNavbar";
import {MyFooter} from "./myfooter/MyFooter"
import { BrowserRouter, Route, Switch } from 'react-router-dom';
import {Forums} from "../modules/forums/Forums";
import {LatestPosts} from "../modules/latests/LatestPosts";
export class App extends React.Component<any, any> {

    render() {
        return (
            <div className={"App"}>

                <BrowserRouter>
                    <MyNavbar/>
                    <Switch>
                        <Route exact={true} path={"/"} component={Forums}/>
                        {/*<Route path={"/whats-new/profile-posts"} component={LatestProfilePosts}/>*/}
                        <Route path={"/whats-new/posts"} component={LatestPosts}/>
                    </Switch>
                    <MyFooter/>
                </BrowserRouter>

            </div>
        )
    }

}
