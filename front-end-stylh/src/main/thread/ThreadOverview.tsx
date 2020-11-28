import React from "react";
import './ThreadOverview.css'

export interface ThreadProps {
    id: string,
    title: string,
    replies: number,
    views: number,
    author: string,
    postTime: string
}



export class ThreadOverview extends React.Component<ThreadProps> {
    render() {
        return (
            <>
                <div className={"body-thread-overview"}>
                    <div className={"title-thread-overview"}>
                        <p>{this.props.title}</p>
                        <div className={"title-author-thread-overview"}>{this.props.author} . {this.props.postTime}</div>
                    </div>
                    <div className={"end-thread-overview"}>
                        <div className={"end-thread-info-overview"}>
                            <div className={"end-thread-replies-info"}>
                                <div>Replies:&nbsp;&nbsp;</div>
                                <div>{this.props.replies}</div>
                            </div>
                            <div className={"end-thread-views-info"}>
                                <div>Views:</div>
                                <div>{this.props.views}</div>
                            </div>
                        </div>
                    </div>
                </div>
            </>
        );
    }
}
