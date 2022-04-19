<!DOCTYPE html>
<html lang="en">

<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		
		<!-- Bootstrap -->
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
		
		<title>Welcome to Revature</title>
		
		<style>

          body {
              background-color: #B8FFF9;
          }

          .form {
              height: 500px;
              width: 30%;
              padding: 10px;
              margin: 1px;
              font-size: large;
              left: 50%;
              top: 50%;
              position: absolute;
              transform: translate(-50%, -50%);
              background-color: black;
              border-radius: 25px;
          }

          input {
              position: relative;
              transform: translate(50%, 250%);
              width: 50%;
              padding: 12px 20px;
              box-sizing: border-box;
              margin: 8px 0;
              border-radius: 50px;
              background-color: rgba(0, 9, 44, 0.8);
              color: aliceblue;
              border-color: #42C2FF;
              opacity: 0.8;
              text-align: center;
          }

          #submit {
              border-color: #B8FFF9;
          }

          #submit:hover {
              background-color: aqua;
              color: black;
          }

          #image {
              height: 125px;
              width: 125px;
              border-radius: 50%;
              position: relative;
              transform: translate(80%, 10%);
          }
		
		</style>

</head>

<body>
<div class="form">
		<form action="login" method="get">
				<!-- <img id="image" src="logo.svg" alt="logo"> -->
				<input type="text" name="userName" id="userName" placeholder="Username" required> <br>
				<input type="password" name="userPassword" id="userPassword" placeholder="Password" required> <br>
				<input type="submit" id="submit" value="Login" placeholder="Login">
		
		</form>
</div>
</body>

</html>