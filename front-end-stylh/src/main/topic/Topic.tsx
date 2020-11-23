import React from "react";
import {FontAwesomeIcon} from "@fortawesome/react-fontawesome";
import './Topic.css'
import {faComments} from "@fortawesome/free-solid-svg-icons";

interface TopicProps {
    title: string,
    threads: number,
    messages: number
}
export class Topic extends React.Component<TopicProps, any> {
    render() {
        return (
            <div className={"body-topic"}>
                <div className={"title-topic"}>
                    <FontAwesomeIcon icon={faComments} size={"2x"} style={{color: "#ffba8c", marginRight: "3px"}}/>
                    <p>{this.props.title}</p>
                </div>
                <div className={"end-topic"}>
                    <div className={"end-topic-info"}>
                        <p style={{color:"#8f9193", fontSize: "80%"}}>Threads</p>
                        <p>{this.props.threads}</p>
                    </div>
                    <div className={"end-topic-info"}>
                        <p style={{color:"#8f9193", fontSize: "80%"}}>Messages</p>
                        <p>{this.props.messages}</p>
                    </div>
                </div>
            </div>
        );
    }
}
