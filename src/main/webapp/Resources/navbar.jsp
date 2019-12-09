<html>
    <head>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
       <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
    
    </head>

    <nav class="navbar navbar-expand-lg navbar-dark bg-success">
        <a  class="navbar-brand" href="index.jsp"><i class="fab fa-napster"> StoreMusic</i></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item ">
                    <a class="nav-link"  href="/TiendaMusica/pais?action=index"><i class="fas fa-globe">&nbsp;Pais</i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"  href="/TiendaMusica/compania?action=index"><i class="fas fa-building">&nbsp;Compañia</i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/TiendaMusica/emusica?action=index"><i class="fas fa-microphone">&nbsp;Estilo Musical</i></a>
                </li>
                
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fas fa-user-tag">&nbsp;Elenco</i>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/TiendaMusica/artistas?action=index"><i class="fas fa-user-tie">&nbsp;Artistas</i></a>
                        <a class="dropdown-item" href="/TiendaMusica/grupo?action=index"><i class="fas fa-users">&nbsp;Grupo</i></a>
                    </div>
                </li>
                
                 <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="fab fa-discourse">&nbsp;Discos</i>
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a class="dropdown-item" href="/TiendaMusica/coleccion?action=index"><i class="fas fa-podcast">&nbsp;Coleccion</i></a>
                        <a class="dropdown-item" href="/TiendaMusica/individual?action=index"><i class="fas fa-compact-disc">&nbsp;Individual</i></a>
                        <a class="dropdown-item" href="/TiendaMusica/pistas?action=index"><i class="fas fa-file-audio">&nbsp;Pistas</i></a>
                    </div>
                </li>
                
                  <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="far fa-edit">&nbsp;Ediciones</i>
                    </a>
                    <div  class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                        <a  class="dropdown-item" href="/TiendaMusica/dedicion?action=index"><i class="fas fa-info-circle">&nbsp;Detalle</i></a>
                    </div>
                </li>
                

            </ul>
        </div>
    </nav>
    <br>
</html>