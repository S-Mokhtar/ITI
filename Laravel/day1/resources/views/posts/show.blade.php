@extends('layouts.app')

@section('title')View @endsection

@section('content')
<div class="container p-5">
    <div class="card mb-5">
        <div class="card-header">
            Post info
        </div>
        <div class="card-body">
            <p class="lead"><strong>Title: </strong>{{$posts->title}}</p>
            <p class="lead"><strong>Description: </strong></p>
        </div>
    </div>
    <!--{{\Carbon\Carbon::parse($posts->created_at)->format('D d').'th of '.\Carbon\Carbon::parse($posts->created_at)->format('M Y h:m:s A')}}-->

    <div class="card">
        <div class="card-header">
            Post creator info
        </div>
        <div class="card-body">
            <p class="lead"><strong>Name: </strong>{{ $posts->post_creator}}</p>
            <p class="lead"><strong>Email: </strong>{{ $posts->post_creator}}@gmail.com</p>
            <p class="lead"><strong>Created At: </strong>{{\Carbon\Carbon::parse($posts->created_at)->isoFormat('dddd Do of MMMM YYYY h:mm:ss A')}}</p>
        </div>
    </div>
</div>
@endsection


