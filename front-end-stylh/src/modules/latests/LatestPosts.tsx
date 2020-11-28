import React from "react";
import {Template} from "../../Template";
import {loadAllNewThreads} from "../../main/webservice/ThreadWebService";
import {ThreadOverview} from "../../main/thread/ThreadOverview";

export class LatestPosts extends React.Component<any, any> {
    render() {
        function loadExtraContent() {
            return (
                <div style={{backgroundColor: "red"}}>
                    Contents goes here!!!
                </div>
            );
        }

        return (
            <Template extraContent={loadExtraContent()}
                      mainContent={this.loadMainContent()}/>
        );
    }

    loadMainContent() {
        return (
            <>
                {loadAllNewThreads().map(thread => (<ThreadOverview id={thread.id}
                                                                    title={thread.title}
                                                                    replies={thread.replies}
                                                                    views={thread.views}
                                                                    author={thread.author}
                                                                    postTime={thread.postTime}/>))}
            </>
        );
    }
}
