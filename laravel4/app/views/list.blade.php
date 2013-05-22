@extends('template.master')

@section('title') Hola Bootstrap @stop

@section('menu')
    @include('partial.navbar')
@stop

@section('content')
    <div class="container">
            <div class="row">
                <div class="span1">&nbsp;</div>
            </div>
            <div class="span8">
                <table class="table table-bordered table-hover">
                    <thead>
                    <tr>
                        <th>#</th>
                        <th>Nombre</th>
                        <th>Cuando</th>
                    </tr>
                    </thead>
                    <tbody>
                    @foreach($datos as $dato)
                        <tr>
                            <td>{{ $dato->codigo }}</td>
                            <td>{{ $dato->nombre }}</td>
                            <td>{{ $dato->cuando }}</td>
                        </tr>

                    @endforeach
                    </tbody>
        </table>
            </div>
        </div>
@stop