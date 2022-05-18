import { clear } from "@testing-library/user-event/dist/clear";
import { Component } from "react";

class ImageSlider extends Component {
  images = ["./image1.png", "./image2.png", "./image3.png"];
  index = 0;
  interval = null;
  constructor() {
    super();
    this.state = {
      image: "./image1.png",
      index :0
    };
  }
  previous=() =>{
    if (this.index > 0) {
      this.index--;
      this.setState({
        image: this.images[this.index],
      });
     // clear(this.interval);
    }
  }
  next=() =>{
       if (this.index < this.images.length-1) {
         this.index++;
         this.setState({
           image: this.images[this.index],
         });
         //clear(this.interval);
       }
  }
  start=()=> {
       
  }
  end=()=> {

  }
  render() {
    return (
      <>
        <img src={this.state.image} style={{width:"700px",height:"700px"}}></img>
        <button onClick={this.previous}>Pervious</button>
        <button onClick={this.next}>Next</button>
        <button onClick={this.start}>Start</button>
        <button onClick={this.end}>Stop</button>
      </>
    );
  }
}
export default ImageSlider;