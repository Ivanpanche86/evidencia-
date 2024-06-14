<div class="modal fade" id="agregarUsuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-info text-white">
                <h5 class="modal-title">Agregar Usuario</h5> 
                <button class="close" data-dismiss="modal">
                    <span>&times;</span>
                </button>
            </div>
            
            <form action="${pageContext.request.contextPath}/SvControladorUsuario?accion=insertar"
                  method="POST" class="was-validated">
                
                <div class="modal-body">
                    <div class="form-group">
                        <label for="id_Usuario">id_Usuario</label>
                        <input type="text" class="form-control" name="id_Usuario" required>
                    </div>
                    <div class="form-group">
                        <label for="numero_documento">numero_documento</label>
                        <input type="text" class="form-control" name="numero_documento" required>
                    </div>
                    <div class="form-group">
                        <label for="tipo_documento">tipo_documento</label>
                        <input type="text" class="form-control" name="tipo_documento" required>
                    </div>
                    <div class="form-group">
                        <label for="nombre">Nombres</label>
                        <input type="text" class="form-control" name="nombres" required>
                    </div>
                    <div class="form-group">
                        <label for="apellidos">Apellidos</label>
                        <input type="text" class="form-control" name="apellidos" required>
                    </div>
                    <div class="form-group">
                        <label for="tipo_usuario">tipo_usuario</label>
                        <input type="email" class="form-control" name="tipo_usuario" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono1">Teléfono1</label>
                        <input type="tel" class="form-control" name="telefono1" required>
                    </div>
                    <div class="form-group">
                        <label for="telefono2">Teléfono2</label>
                        <input type="tel" class="form-control" name="telefono2" required>
                    </div>
                    <div class="form-group">
                        <label for="e_mail">e_mail</label>
                        <input type="number" class="form-control" name="e_mail" required step="any">
                    </div>
                    <div class="form-group">
                        <label for="torre_apartamento">torre_apartamento</label>
                        <input type="number" class="form-control" name="torre_apartamento" required step="any">
                    </div>
                    <div class="form-group">
                        <label for="contraseña">contraseña</label>
                        <input type="number" class="form-control" name="contraseña" required step="any">
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-primary" type="submit">Guardar</button>
                    <form action="SvControladorUsuario" method="post">
                         <button type="submit">Enviar</button>
                    </form>

                </div>    
            </form>
        </div>
    </div>
</div>
    
