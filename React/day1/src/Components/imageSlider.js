import { clear } from "@testing-library/user-event/dist/clear";
import { Component } from "react";
import Button from "react-bootstrap/Button";

class ImageSlider extends Component {
  images = ["./image1.png", "./image2.png", "./image3.png"];
  index = 0;
  interval = null;
  constructor() {
    super();
    this.state = {
      image: "./image1.png",
      index: 0,
    };
  }
  previous = () => {
    if (this.index > 0) {
      this.index--;
      this.setState({
        image: this.images[this.index],
      });
       clear(this.interval);
    }
  };
  next = () => {
    if (this.index < this.images.length - 1) {
      this.index++;
      this.setState({
        image: this.images[this.index],
      });
      clear(this.interval);
    }
  };
  slide = () => {
    this.interval = setInterval(this.start, 1000);
  };
  start = () => {
    if (this.index < this.images.length - 1) {
      this.index++;
      this.setState({ image: this.images[this.index] });
    } else {
      this.index = 0;
      this.setState({ image: this.images[this.index] });
    }
  };
  end = () => {
    clearInterval(this.interval);
  };
  render() {
    return (
      <>
        <img
          className="mb-2"
          src={this.state.image}
          style={{ width: "500px", height: "300px" }}
        />
        <br></br>
        <button className="btn btn-info ms-2" onClick={this.previous}>
          Pervious
        </button>
        <button className="btn btn-info ms-2" onClick={this.next}>
          Next
        </button>
        <button className="btn btn-info ms-2" onClick={this.slide}>
          Start
        </button>
        <button className="btn btn-info ms-2" onClick={this.end}>
          Stop
        </button>
      </>
    );
  }
}
export default ImageSlider;