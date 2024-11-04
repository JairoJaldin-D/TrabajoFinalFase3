const cartContainer = document.getElementById('cart-container');
const apiCartURL = 'http://localhost:8080/carts/';

const contadorId = document.getElementById('contador-id');

//funcion que obtiene el carrito
async function getCart() {

    var cartId = window.location.href.split("/").reverse()[0]

    cartUrl = apiCartURL+cartId;

    const response = await fetch(cartUrl);

    const cart = await response.json();

    var html = "";

    for (let i = 0; i < cart.items.length; i++) {
       html = html + item(cart.items[i]);
    }

    html = html + "<br><br>";
    html = html + "<div class='row'> Precio Total: $ " + cart.totalPrice + " </div>";
    html = html + "<br><br>";

    html = html + " <div class='row'>   <a onclick='purchase()' class='btn btn-primary'>Comprar</a>  </div>";
    html = html + "<br>";
    html = html + " <div class='row'>   <a onclick='deleteCartById()' class='btn btn-primary'>Eliminar carrito</a>  </div>";


    cartContainer.innerHTML = html;

}

//arma un item
function item(oneItem) {

  return "<div class='row'>"
           + "<div class='col'>"
           +     oneItem.name
           + "</div>"
           + "<div class='col'>"
           +   " $ "
           + oneItem.price
           + "</div>"
           + "<div class='col'>"
           +     oneItem.quantity
           + "</div>"
        +"</div>";

}


//Funcion que va a llamar al carrito y va a contar items
async function counterItems() {

    var cartId = window.location.href.split("/").reverse()[0];

    cartUrl = apiCartURL+cartId;

    const response = await fetch(cartUrl);

    const cart = await response.json();

    contadorId.innerHTML = cart.items.length;

}

//funcion para eliminar carrito
async function deleteCartById() {
  var cartId = window.location.href.split("/").reverse()[0];

  var cartUrl = apiCartURL+cartId;

  const response = await fetch(cartUrl, {
      method: "DELETE",
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    });

  const responseDelete = await response.json();

  sessionStorage.clear();

  alert("Carrito borrado exitosamente");

  window.location.href = "http://localhost:8080/web/index" ;

}

function purchase() {
  alert('id de compra: '+ uuid.v4() );
  sessionStorage.clear();
  window.location.href = "http://localhost:8080/web/index" ;
}

//llamamos a la funcion de carrito
getCart();
counterItems();
