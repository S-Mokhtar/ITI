<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class PostController extends Controller
{
    private function sendArray(){
        $posts = [
            ['id' => 1, 'title' => 'Laravel', 'post_creator' => 'Ahmed', 'created_at' => '2022-04-16 10:37:00'],
            ['id' => 2, 'title' => 'PHP', 'post_creator' => 'Mohamed', 'created_at' => '2022-04-16 10:37:00'],
            ['id' => 3, 'title' => 'Javascript', 'post_creator' => 'Ali', 'created_at' => '2022-04-16 10:37:00'],
        ];
        return $posts;
    }
    public function index()
    {
        $posts=$this->sendArray();
        // dd($posts); for debugging
        return view('posts.index',[
            'posts' => $posts,
        ]);
    }

    public function create()
    {
        return view('posts.create');
    }

    public function store()
    {
        return 'we are in store';
    }

    public function show($postId)
    {
        $posts=$this->sendArray();
        foreach  ( $posts as $post) {
            if($post['id']==$postId){
                $posts=$post;
            }
        }
        return view('posts.show',[
            'posts' => $posts,
        ]);
    }
    public function edit($postId)
    {
        $posts=$this->sendArray();
        foreach  ( $posts as $post) {
            if($post['id']==$postId){
                $posts=$post;
            }
        }
        return view('posts.edit',[
            'posts' => $posts,
        ]);
    }

    public function delete($postId)
    {
        $posts=$this->sendArray();
        foreach  ( $posts as $post) {
            if($post['id']==$postId){
                $posts=$post;
            }
        }
        return view('posts.delete',[
            'posts' => $posts,
        ]);
    }

    public function destroy()
    {
        return 'we are in destroy';
    }
}
