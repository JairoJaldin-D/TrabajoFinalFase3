const productsContainer = document.getElementById('products-container');

const apiProductsURL = 'http://localhost:8080/products';

const apiCreateCartURL = 'http://localhost:8080/carts';

const contadorId = document.getElementById('contador-id');

const apiCartURL = 'http://localhost:8080/carts/';


//funcion que obtiene productos
async function getProducts() {
    const response = await fetch(apiProductsURL);

    const allProductsArr = await response.json();

    var html = "";

    for (let i = 0; i < allProductsArr.length; i++) {
       html = html + product(allProductsArr[i]);
    }
    productsContainer.innerHTML = html;

}

//arma un producto
function product(oneProduct) {

  return " <div class='card' style='width: 18rem;'>"
         + "<img src='"+ oneProduct.image +"' class='card-img-top' alt='...'>"
         + "<div class='card-body'>"
         +    "<h5 class='card-title'>" + oneProduct.name + "</h5>"
         +    "<p class='card-text'>"+ oneProduct.description + "</p>"
         +    "<p>Price $ " + oneProduct.price + "</p>"
         +    "<a onclick='addItem("+ oneProduct.id +")' class='btn btn-primary'>Agregar al carrito</a>"
         + "</div>"
         + "</div>";

}


async function addItem(productId) {

  var cartId = sessionStorage.getItem("cartId");

  if (cartId === null || cartId === 'undefined' ) {
    // creamos carrito
    await createCart();
    // agregamos item al carrito
    await addItemToCart(productId, 1);
  } else {
    // agregamos item al carrito
    await addItemToCart(productId, 1);

  }
  await counterItems();

  alert("Producto agregado al cerrito exitosamente");

}

// funcion para crear el carrito
async function createCart() {

  const response = await fetch(apiCreateCartURL, {
      method: "POST",
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    });

    const createdCart = await response.json();

    sessionStorage.setItem("cartId", createdCart.id);
}

async function addItemToCart(paramProductId, paramQuantity) {

  var cartId = sessionStorage.getItem("cartId");

  var url = apiCreateCartURL + "/" + cartId + "/items";

  const response = await fetch(url, {
      method: "PUT",
      body: JSON.stringify({
           productId: paramProductId,
           quantity : paramQuantity
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8"
      }
    });

    const item = await response.json();
    console.log(item);

}

async function showCart() {

 var cartId = sessionStorage.getItem("cartId");

 if (cartId === null || cartId === 'undefined' ) {
    // creamos carrito vacio
    await createCart();
    cartId = sessionStorage.getItem("cartId");

  }

  window.location.href = "http://localhost:8080/web/cart/"+cartId ;
}

//Funcion que va a llamar al carrito y va a contar items
async function counterItems() {

   var cartId = sessionStorage.getItem("cartId");

   if (cartId === null || cartId === 'undefined' ) {
       contadorId.innerHTML = 0;
   } else {
       cartUrl = apiCartURL+cartId;

       const response = await fetch(cartUrl);

       const cart = await response.json();

       contadorId.innerHTML = cart.items.length;
   }

}



//llamamos a la funcion
getProducts();
counterItems();
