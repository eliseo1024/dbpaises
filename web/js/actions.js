function edit(idPais, siglas, capital, cantHabitantes, extenTerritorio, idioma, moneda)
{
    document.getElementById("txtIdPais").value = idPais;
    document.getElementById("txtSiglas").value = siglas;
    document.getElementById("txtCapital").value = capital;
    document.getElementById("txtCantHabitantes").value = cantHabitantes;
    document.getElementById("txtExtenTerritorio").value = extenTerritorio;
    document.getElementById("txtIdioma").value = idioma;
    document.getElementById("txtMoneda").value = moneda;
}

function ocultar(){
document.getElementById('crear').style.display = 'none';
}

