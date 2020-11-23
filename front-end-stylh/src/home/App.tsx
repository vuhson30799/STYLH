import React from 'react';
import {Cell, Grid} from 'react-flexr';
import './App.css';
import 'react-flexr/styles.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import MyNavbar from "./mynavbar/MyNavbar";
import {MainTopic} from "../main/maintopic/MainTopic";
import {MyFooter} from "./myfooter/MyFooter"
import {loadMainTopicsForApp} from "../main/webservice/TopicWebServices";

interface MainTopicData {
    mainTopics: {
        id: string,
        title: string
    }[]
}

export class App extends React.Component<any, MainTopicData> {
    constructor(props: any) {
        super(props);
        this.state = {
            mainTopics: [{
                id: "",
                title: ""
            }]
        }
    }
    render() {
        return (
            <div className={"App"}>
                <MyNavbar/>
                <Grid align={"center"}>
                    <Cell size={'1/12'} align={"center"}>
                    </Cell>
                    <Cell size={'10/12'}>
                        <Grid>
                            <Cell size={"8/12"}>
                                <div>
                                    {this.state.mainTopics.map((mainTopic: any) => (<MainTopic id={mainTopic.id} title={mainTopic.title}/>))}
                                </div>
                            </Cell>
                            <Cell size={"4/12"} align={"center"}>
                                <div style={{backgroundColor: "red"}}>
                                    Contents goes here!!!
                                </div>
                            </Cell>
                        </Grid>
                    </Cell>
                    <Cell size={'1/12'}>
                    </Cell>
                </Grid>
                <MyFooter/>
            </div>
        )
    }

    componentDidMount() {
        this.setState({mainTopics: loadMainTopicsForApp()})
    }

}
