@extends('layouts.app')

@section('title')Edit @endsection

@section('content')
        <form method="POST" action="{{ route('posts.index')}}">
            @csrf
            <div class="mb-3">
                <label for="exampleFormControlInput1" class="form-label">Title</label>
                <input type="text" class="form-control" id="exampleFormControlInput1" placeholder="{{ $posts['title'] }}">
            </div>
            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Description</label>
                <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
            </div>

            <div class="mb-3">
                <label for="exampleFormControlTextarea1" class="form-label">Post Creator</label>
                <select class="form-control">
                    <option value="1">{{ $posts['post_creator'] }}</option>
                    <option value="2">Mohamed</option>

                </select>
            </div>

          <button class="btn btn-primary">Update</button>
        </form>
@endsection
    
