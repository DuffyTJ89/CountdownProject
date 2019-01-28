import React from "react";
import axios from "axios";

export default class ScrabbleApp extends React.Component {

    createTable = () => {
        let table = []

        // Outer loop to create parent
        for (let i = 0; i < 15; i++) {
            let children = []
            //Inner loop to create children
            for (let j = 0; j < 15; j++) {
                //children.push(<td>{`Column ${j + 1}`}</td>)
                children.push(<td><button type="button" onClick={this.backEndCallTest(i, j)}>
                    Test button {i + 1} {j + 1}
                </button></td>)
            }
            //Create the parent and add the children
            table.push(<tr>{children}</tr>)
        }
        return table
    }

    backEndCallTest = (x, y) => {
        axios.get("/scrabble/v1/test?x=" + x + "&y=" + y)
            .then(response => {
                console.log(response.data);
            })
            .catch(err => {
                console.log(err);
            });
    }


    render() {
            return(
                <table>
                    {this.createTable()}
                </table>
            )
        }

        // return (
        //     <button type="button" onClick={this.backEndCallTest}>
        //         Test button
        //     </button>
        // )
    //}
}