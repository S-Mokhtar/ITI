import { Component } from 'react'
class Text extends Component {
    constructor() {
        super();
        this.state = {
            userName: ""
        };
    }
    render() {
        return (
          <div>
            <input
              type="text"
              value={this.state.userName}
              onChange={(e) => {
                this.setState({ userName: e.target.value });
              }}
            />
            <p>{this.state.userName}</p>
            <button
              className="btn btn-info mb-2"
              onClick={(e) => {
                this.setState({ userName: "" });
              }}
            >
              Reset
            </button>
          </div>
        );
    }

}

export default Text;