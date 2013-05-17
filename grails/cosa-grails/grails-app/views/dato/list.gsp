<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Hola Bootstrap</title>
    <r:require modules="bootstrap" />

</head>
<body>
<g:render template="/templates/navbar" />

<div class="container">
    <div class="row">
        <div class="span1 ">&nbsp;</div>

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

                <g:each in="${datos}" var="dato">
                    <tr>
                        <td>${dato.codigo}</td>
                        <td>${dato.nombre}</td>
                        <td>${dato.cuando}</td>
                    </tr>
                </g:each>
                </tbody>
            </table>
        </div>
    </div>

</div>
</body>
</html>
