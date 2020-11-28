import React from "react";
import {Cell, Grid} from "react-flexr";

export interface ContentTemplate {
    mainContent: React.ComponentElement<any, any>,
    extraContent: React.ComponentElement<any, any>
}

export class Template extends React.Component<ContentTemplate, any> {

    render() {
        return (
            <Grid align={"center"}>
                <Cell size={'1/12'} align={"center"}>
                </Cell>
                <Cell size={'10/12'}>
                    <Grid>
                        <Cell size={"8/12"}>
                            <div style={{marginTop:"55px"}}>
                                {this.props.mainContent}
                            </div>
                        </Cell>
                        <Cell size={"4/12"} align={"center"}>
                            {this.props.extraContent}

                        </Cell>
                    </Grid>
                </Cell>
                <Cell size={'1/12'}>
                </Cell>
            </Grid>
        );
    }
}
