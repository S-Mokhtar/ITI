<?php

namespace App\View\Components;

use Illuminate\View\Component;

class Button extends Component
{
    public $to;
    public $type;
    public $text;
    /**
     * Create a new component instance.
     *
     * @return void
     */
    public function __construct($to, $type, $text, $icon='')
    {
        $this->to = $to;
        $this->text = $text;
        $this->type = $type;
    }

    /**
     * Get the view / contents that represent the component.
     *
     * @return \Illuminate\Contracts\View\View|\Closure|string
     */
    public function render()
    {
        return view('components.button',[
            'to'=>$this->to,
            'text'=>$this->text,
            'type'=>$this->type
        ]);
    }
}


