@extends('layouts.app')

@section('title')Edit @endsection

@section('content')
        <form method="POST" action="{{ route('posts.update',$posts->id)}}" enctype="multipart/form-data">
            @csrf
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Title</label>
                <input name="title" type="text" class="form-control" id="exampleFormControlInput1" placeholder="{{ $posts->title}}">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                <textarea name="description" class="form-control" id="exampleFormControlTextarea1" placeholder="{{ $posts->description}}" rows="3"></textarea>
            </div>

            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
                <select name="post_creator" class="form-control">
                @foreach ($users as $user)
                        <option value="{{$user->id}}">{{$user->name}}</option>
                @endforeach
                </select>
            </div>
            <div class="mb-3">
        <label for="image">Image</label>
        <input type="file" class="form-control-file" name="image">
    </div>

          <button class="btn btn-primary">Update</button>
        </form>
@endsection
    
