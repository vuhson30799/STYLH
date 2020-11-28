import React from "react";
import './TopicOverview.css'
import {loadAllThreadsForTopic} from "../webservice/ThreadWebService";
import {ThreadOverview} from "../thread/ThreadOverview";

interface TopicProps {
    id: string,
    title: string,
    threads: number,
    messages: number
}

interface ThreadData {
    threads: {
        id: string,
        title: string,
        replies: number,
        views: number,
        author: string,
        postTime: string
    }[]
}

export class Topic extends React.Component<TopicProps, ThreadData> {
    constructor(props: TopicProps) {
        super(props);
        this.state = {
            threads: [{
                id: '',
                title: '',
                replies: 0,
                views: 0,
                author: '',
                postTime: ''
            }]
        }
    }
    render() {
        return (
            <div>
                <div className={"filter-topic"}>Filter</div>
                <div>
                    {this.state.threads.map(thread => (<ThreadOverview id={thread.id}
                                                                       title={thread.title}
                                                                       author={thread.author}
                                                                       views={thread.views}
                                                                       replies={thread.replies}
                                                                       postTime={thread.postTime}/>))}
                </div>
            </div>
        );
    }

    componentDidMount() {
        this.setState({threads: loadAllThreadsForTopic(this.props.id)})
    }
}
