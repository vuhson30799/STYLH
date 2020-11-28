import React from "react";
import {Template} from "../../Template";
import {loadMainTopicsForApp} from "../../main/webservice/TopicWebServices";
import {MainTopic} from "../../main/maintopic/MainTopic";

interface MainTopicData {
    mainTopics: {
        id: string,
        title: string
    }[]
}

export class Forums extends React.Component<any, MainTopicData> {
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
        function loadExtraContent() {
            return (<div style={{backgroundColor: "red"}}>
                Contents goes here!!!
            </div>);
        }

        return (
            <>
                <Template mainContent={this.loadMainContent()}
                          extraContent={loadExtraContent()}/>
            </>
        );
    }

    componentDidMount() {
        this.setState({mainTopics: loadMainTopicsForApp()})
    }

    loadMainContent() {
        return (
            <div>
                {this.state.mainTopics.map((mainTopic: any) => (<MainTopic id={mainTopic.id} title={mainTopic.title}/>))}
            </div>
        );
    }
}
