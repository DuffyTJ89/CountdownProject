import React from "react";
import HeaderComponent from "./HeaderComponent";
import Form from "./Form";


export default class ScrabbleApp extends React.Component {

    state = {
        playerId: undefined,
        playerColour: undefined,
        loggedIn: false,
        currentGameId: undefined,
        gameStatus: undefined,
        yourTurn: undefined,
        ongoingGames: [],
        playerName: undefined
    };

    render() {
        return (
            <div>
                <div className="container">
                    <HeaderComponent
                        title="Scrabble Online"
                    />


                    <Form

                        loggedIn={this.state.loggedIn}

                    />
                </div>
            </div>
        );
    }



}//ScrabbleApp