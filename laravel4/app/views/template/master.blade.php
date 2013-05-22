<!DOCTYPE html>

<html>
    <head>
        <title>@yield('title')</title>
        <link rel="stylesheet" href={{ URL::asset("assets/css/bootstrap.min.css") }}>
        <style>
        body {
            padding-top: 60px;
        }
        </style>
    </head>
    <body>
        @yield('menu')
        @yield('content')
        <script src="http://code.jquery.com/jquery.js"></script>
        <script src={{ URL::asset("assets/js/bootstrap/bootstrap.min.js") }}></script>
    </body>
</html>