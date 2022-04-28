<?php

namespace App\Http\Controllers\Api;

use App\Http\Requests\StorePostRequest;
use App\Http\Controllers\Controller;
use Illuminate\Http\Request;
use App\Models\Post;

class PostController extends Controller
{
    public function index(){
        return Post::all();
    }
    public function show($postId){
        $post = Post::find($postId);
        return [
            'id'=> $post->id,
            'title'=> $post->title,
            'description'=> $post->description,
            'user_id'=> $post->user_id,
        ];
    }
    public function store(StorePostRequest $request){
        $data = request()->all();
        $post = Post::create([
            'title' => $data['title'],
            'description' => $data['description'],
            'user_id' => $data['post_creator'],
            'image'=>$request->file('image'),
        ]);
        return [
            'id'=> $post->id,
            'title'=> $post->title,
            'description'=> $post->description,
            'user_id'=> $post->user_id,
        ];
    }
}
