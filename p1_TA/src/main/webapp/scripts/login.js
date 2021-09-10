let loginForm = document.getElementById("login-form");

window.onload = async function(){
    const sessionRes = await fetch(`${domain}/api/check-session`);
    const sessionUserData = await sessionRes.json();

    if(sessionUserData.data){
        if(sessionUserData.data.userRoleId == 1){
        window.location = `${domain}/employee-reimbursements?usersId=${sessionUserData.data.usersId}`
        }
        else if(sessionUserData.data.userRoleId == 2){
            window.location = `${domain}/manager-reimbursements?usersId=${sessionUserData.data.usersId}`
        }
    }
}

loginForm.onsubmit = async function(e){
    e.preventDefault();

    //get values from the input field
    let userName = document.getElementById("username").value;
    let userPassword = document.getElementById("password").value;

    //comment this out whenever presenting
    console.log(userName, userPassword);

    //send values to the backend
    let response = await fetch(`${domain}/api/login`,{
        method: "POST",
        body: JSON.stringify({
            userName: userName,
            userPassword: userPassword
        })
    })

    let responseData = await response.json();
    console.log(responseData);

    if(responseData.success){
        if(responseData.data.userRoleId == 1){
            window.location = `${domain}/employee-reimbursements?usersId=${responseData.data.usersId}`
        }
        else if(responseData.data.userRoleId == 2){
            window.location = `${domain}/manager-reimbursements?usersId=${responseData.data.usersId}`
        }
    }else{
        let messageElem = document.getElementById("login-message")
        messageElem.style = "background-color: pink;"
        messageElem.innerText = responseData.message
    }
}