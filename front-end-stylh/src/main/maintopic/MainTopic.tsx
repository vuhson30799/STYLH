import React from "react";
import {Topic} from "../topic/Topic";
import {loadTopicsForMainTopic} from "../webservice/TopicWebServices";
import './MainTopic.css'

interface MainTopicProps {
    id: string,
    title: string
}

interface TopicData {
    topics: {
        title: string,
        threads: number,
        messages: number
    }[]
}
export class MainTopic extends React.Component<MainTopicProps, TopicData > {
    constructor(props: MainTopicProps) {
        super(props);
        this.state = {
            topics: [{
                title: "",
                threads: 0,
                messages: 0
            }]
        }
    }

    render() {
        return (
            <div className={"body-main-topic"}>
                <h3 className={"title-main-topic"}>{this.props.title}</h3>
                {this.state.topics.map((topic: any) => (<Topic title={topic.title} threads={topic.threads} messages={topic.messages}/>))}
            </div>

        );
    }

    componentDidMount() {
        this.setState({topics: loadTopicsForMainTopic(this.props.id)})
    }
}
