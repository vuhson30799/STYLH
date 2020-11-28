import React from "react";
import {TopicOverview} from "../topic/TopicOverview";
import {loadTopicsForMainTopic} from "../webservice/TopicWebServices";
import './MainTopic.css'

interface MainTopicProps {
    id: string,
    title: string
}

interface TopicData {
    topics: {
        id: string,
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
                id: "",
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
                {this.state.topics.map((topic: any) => (<TopicOverview id={topic.id} title={topic.title} threads={topic.threads} messages={topic.messages}/>))}
            </div>

        );
    }

    componentDidMount() {
        this.setState({topics: loadTopicsForMainTopic(this.props.id)})
    }
}
