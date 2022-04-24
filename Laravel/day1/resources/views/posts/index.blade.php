@extends('layouts.app')

@section('title')Index @endsection

@section('content')
<div class="text-center">
  <a href="{{ route('posts.create') }}" class="mt-4 btn btn-success">Create Post</a>
</div>
<table class="table mt-4">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Title</th>
      <th scope="col">Posted By</th>
      <th scope="col">Created At</th>
      <th scope="col">Slug</th>
      <th scope="col">Image</th>
      <th scope="col">Actions</th>
    </tr>
  </thead>
  <tbody>
    @foreach ( $posts as $post)
    <tr>
      <td>{{ $post->id }}</th>
      <td>{{ $post->title }}</td>
      @if($post->user)
      <td>{{$post->user->name}}</td>
      @else
      <td>Not Found</td>
      @endif
      <td>{{\Carbon\Carbon::parse($post->created_at)->format('Y-m-d') }}</td>
      <td>{{$post->slug ? $post->slug : 'Not Found'}}</td>
      <td>{{$post->image ? $post->image : 'Not Found'}}</td>
      <td>
        <div class="d-flex">
          <x-button to="{{route('posts.show', ['post' =>$post->id])}}" text="View" type="primary" />
          <x-button to="{{route('posts.edit', ['post' => $post->id])}}" text="Edit" type="success" />
          <x-button to="{{route('posts.delete', ['post' => $post->id])}}" text="Delete" type="danger" />
        </div>
      </td>
    </tr>
    @endforeach

  </tbody>
</table>
<div>
  {{$posts->links()}}
</div>
@endsection