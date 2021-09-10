const urlParams = new URLSearchParams(window.location.search);
const usersId = urlParams.get("usersId");

window.onload = async function(){
    //check session
    const sessionRes = await fetch(`${domain}/api/check-session`);
    const sessionUserData = await sessionRes.json();

    let welcomeText = document.getElementById("nav-bar-text");
    welcomeText.innerHTML = `${sessionUserData.data.userFirstName} ${sessionUserData.data.userLastName}, ${sessionUserData.data.userRole}: Dashboard!`;

    console.log(sessionUserData)
    if(sessionUserData.data){
        if(sessionUserData.data.usersId != usersId){
            window.location = `${domain}/`
        }
    }else {
        window.location = `${domain}/`
    }
    populateData();
}

async function populateData(){
    //fetch list of reimbursements assigned to specific usersId
    const reimbListResponse = await fetch(`${domain}/api/employee-reimbursements?usersId=${usersId}`)
    const reimbListData = await reimbListResponse.json();

    //sort
    reimbListData.data.sort((a,b) => {
        if(a.reimbId < b.reimbId){
            return -1;
        }
        if(a.reimbId > b.reimbId){
            return 1;
        }
        return 0;
    })

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    let reimbTable = document.getElementById("reimb-table");
    let reimbTableRow = reimbTable.insertRow();
    let cell1 = reimbTableRow.insertCell(0);
    cell1.innerHTML = reimbList.reimbId;
    let cell2 = reimbTableRow.insertCell(1);
    cell2.innerHTML = reimbList.reimbAmount;
    let cell3 = reimbTableRow.insertCell(2);
    cell3.innerHTML = reimbList.reimbSubmitted;
    let cell4 = reimbTableRow.insertCell(3);
    cell4.innerHTML = reimbList.reimbResolved;
    let cell5 = reimbTableRow.insertCell(4);
    cell5.innerHTML = reimbList.reimbDescription;
    let cell6 = reimbTableRow.insertCell(5);
    cell6.innerHTML = reimbList.reimbReceipt;
    let cell7 = reimbTableRow.insertCell(6);
    cell7.innerHTML = reimbList.reimbAuthor;
    let cell8 = reimbTableRow.insertCell(7);
    cell8.innerHTML = reimbList.reimbResolver;
/*     let cell9 = reimbTableRow.insertCell(8);
    cell9.innerHTML = reimbList.reimbStatusId;
    let cell10 = reimbTableRow.insertCell(9);
    cell10.innerHTML = reimbList.reimbTypeId; */
    let cell11 = reimbTableRow.insertCell(8);
    cell11.innerHTML = reimbList.reimbStatus;
    let cell12 = reimbTableRow.insertCell(9);
    cell12.innerHTML = reimbList.reimbType;

    })

}

//logout button - shared between both employee & manager pages
let logoutBtn = document.getElementById("logout-btn");
logoutBtn.onclick = async function(){
    let logoutRes = await fetch(`${domain}/api/logout`);
    let logoutResData = await logoutRes.json();

    if(logoutResData.success){
        window.location = `${domain}/`
    }
}

let createReimbForm = document.getElementById("create-reimb-form");

createReimbForm.onsubmit = async function(e){
    e.preventDefault();

    let reimbAmount = document.getElementById("reimb-amount").value;
    let reimbDescription = document.getElementById("reimb-description").value;
    //let reimbAuthor = usersId;
    let reimbType = document.getElementById("reimb-type").value;

    if(reimbAmount && reimbType != null){
        let submitReimbRes = await fetch(`${domain}/api/employee-reimbursements`,{
            method: "POST",
            body: JSON.stringify({
                reimbAmount: reimbAmount,
                reimbDescription: reimbDescription,
                reimbAuthor: usersId,
                reimbTypeId: reimbType
            })
        })
        
        let submitReimbResData = await submitReimbRes.json();
        console.log(submitReimbResData);

        if(submitReimbResData.success){
            window.location = `${domain}/employee-reimbursements?usersId=${usersId}`
        }
    }
}

