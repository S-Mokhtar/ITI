<?php

namespace App\Http\Controllers;

use App\Http\Requests\StorePostRequest;
use App\Http\Requests\UpdatePostRequest;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Str;
use Illuminate\Http\Request;
use App\Models\Post;
use App\Models\User;
use Carbon\Carbon;

class PostController extends Controller
{
    /*private function sendArray(){
        $posts = [
            ['id' => 1, 'title' => 'Laravel', 'post_creator' => 'Ahmed', 'created_at' => '2022-04-16 10:37:00'],
            ['id' => 2, 'title' => 'PHP', 'post_creator' => 'Mohamed', 'created_at' => '2022-04-16 10:37:00'],
            ['id' => 3, 'title' => 'Javascript', 'post_creator' => 'Ali', 'created_at' => '2022-04-16 10:37:00'],
        ];
        return $posts;
    }*/
    public function index()
    {
        $posts = Post::paginate(10);
        // dd($posts); for debugging
        return view('posts.index',[
            'posts' => $posts,
        ]);
    }

    public function create()
    {
        $users = User::all();
        return view('posts.create',[
            'users' => $users,
        ]);
    }

    public function store(StorePostRequest $request)
    {
        $data = request()->all(); //== $_POST
        Post::create([
            'title' => $data['title'],
            'description' => $data['description'],
            'user_id' => $data['post_creator'],
            'image'=>$request->file('image'),
        ]);
        
        return to_route('posts.index');
    }

    public function show($postId)
    {
        /*$posts=$this->sendArray();
        foreach  ( $posts as $post) {
            if($post['id']==$postId){
                $posts=$post;
            }
        }*/

        // $post = Post::where('id', $postId)->first();
        $post = Post::find($postId);
        return view('posts.show',[
            'posts' => $post,
        ]);
    }
    public function edit($postId)
    {
        $post = Post::find($postId);
        $users = User::all();
        return view('posts.edit',[
            'users' => $users,
            'posts' => $post,
        ]);
    }

    public function update(UpdatePostRequest $request, $postId)
    {
        $post = Post::find($postId);
        $data = request()->all();
        $post->update($data);
        return to_route('posts.index');
    }

    public function delete($postId)
    {
        $post = Post::find($postId);
        return view('posts.delete',[
            'posts' => $post,
        ]);
    }

    public function destroy($postId)
    {
        $post = Post::find($postId);
        $post->delete();
        return to_route('posts.index');
    }
}
