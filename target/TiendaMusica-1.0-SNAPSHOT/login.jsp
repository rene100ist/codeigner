<%-- 
    Document   : login
    Created on : 12-05-2019, 11:46:55 AM
    Author     : rene.linaresusam
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    </head>
    <body>
        <div class="container">
            <div class="d-flex justify-content-center h-100">
                <div class="card">
                    <div class="card-header">
                        <h3>Login StoreMusic</h3>

                    </div>
                    <div class="card-body">
                        <form action="usua?action=login" method="post">
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-user"></i></span>
                                </div>
                                <input type="text" class="form-control" placeholder="username" name="usuario" required="">

                            </div>
                            <div class="input-group form-group">
                                <div class="input-group-prepend">
                                    <span class="input-group-text"><i class="fas fa-key"></i></span>
                                </div>
                                <input type="password" class="form-control" placeholder="password" name="pass" required="" >
                            </div>

                            <div class="form-group">
                                <input style="display: ${hid}" type="submit" value="Ingresar" class="btn btn-warning">
                            </div>
                        </form>
                    </div>
                    <div class="card-footer">
                        <div class="d-flex justify-content-center links">
                            Quieres una cuenta?<a href="#exampleModalCenter" data-toggle="modal" >&nbsp;Registrate</a>
                        </div>

                    </div>
                </div>
            </div>

            <!-- ======================================================================================== -->
            <!-- ===================== INGRESANDO USUARIO==================================== -->
            <!-- Modal -->
            <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalCenterTitle">Ingresando Usuario</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            <form action="usua?action=insert" method="post">
                                <div class="row">
                                    <div class="col-8">
                                        <label>Nombre Usuario:</label>
                                        <input type="text" class="form form-control" name="usuario" value="" required="">
                                        <label>Password</label>
                                        <input type="password" class="form form-control" name="pass" value="" required="">
                                        <br>
                                        <button type="submit" class="btn btn-primary">Guardar</button>
                                        </form>
                                    </div>
                                </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </body>
</html>
