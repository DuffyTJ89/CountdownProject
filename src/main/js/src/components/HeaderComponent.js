import React from "react";
import _ from "lodash";

const allOptions = [
    "I can't make anything with these tiles.",
    "Can we check the score? I think I've added up wrong",
    "I know there's something in here somewhere",
    "Do you mind if I take back my word?"

];

export default class HeaderComponent extends React.Component {

    state = {
        selected: _.sample(allOptions)
    }

    componentDidMount() {
        setInterval(() => this.setState({
            selected: _.sample(allOptions)
        }), 5000)
    }

    render() {

            return (
                <div className="container ">
                    <div className="col-12 padded-top" />
                    <div className="row">
                        <div className="col-md-12 col-lg-12 col-sm-12 col-12">
                            <h1 className="text-left page-header display-1 white outline main-header-right">
                                <strong>{this.props.title}</strong>
                            </h1>
                            <h2 className="text-left medium-p main-header-left">
                                {this.state.selected}
                            </h2>
                        </div>
                    </div>
                    <div className="col-12 padded-bot" />
                </div>
            );

    }
}