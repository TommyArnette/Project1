const urlParams = new URLSearchParams(window.location.search);
const usersId = urlParams.get("usersId");

//let reimbFilter = document.getElementById("reimb-filter").value;

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
    retrieveReimb();
}

async function retrieveReimb(){
    //fetch list of all employee reimbursements
    const reimbListResponse = await fetch(`${domain}/api/manager-reimbursements?status=""`)
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

    let reimbTableBody = document.getElementById("reimb-table-body");
    reimbTableBody.innerHTML = ``;

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    
    reimbTableBody.innerHTML += `        
            <tr>
                <td>${reimbList.reimbId}</td>
                <td>${reimbList.reimbAmount}</td>
                <td>${reimbList.reimbSubmitted}</td>
                <td>${reimbList.reimbResolved}</td>
                <td>${reimbList.reimbDescription}</td>
                <td>${reimbList.reimbReceipt}</td>
                <td>${reimbList.reimbAuthor}</td>
                <td>${reimbList.reimbResolver}</td>
                <td>${reimbList.reimbStatus}</td>
                <td>${reimbList.reimbType}</td>
            </tr>    
    `;
   })

}

//all button function
let allBtn = document.getElementById("all-reimb");
allBtn.onclick = async function(e){
    e.preventDefault();
    
    const reimbListResponse = await fetch(`${domain}/api/manager-reimbursements?status=""`)
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

    let reimbTableBody = document.getElementById("reimb-table-body");
    reimbTableBody.innerHTML = ``;

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    
    reimbTableBody.innerHTML += `        
            <tr>
                <td>${reimbList.reimbId}</td>
                <td>${reimbList.reimbAmount}</td>
                <td>${reimbList.reimbSubmitted}</td>
                <td>${reimbList.reimbResolved}</td>
                <td>${reimbList.reimbDescription}</td>
                <td>${reimbList.reimbReceipt}</td>
                <td>${reimbList.reimbAuthor}</td>
                <td>${reimbList.reimbResolver}</td>
                <td>${reimbList.reimbStatus}</td>
                <td>${reimbList.reimbType}</td>
            </tr>    
    `;
    })

}

//PENDING button function
let pendingBtn = document.getElementById("pending-reimb");
pendingBtn.onclick = async function(e){
    e.preventDefault();

    const reimbListResponse = await fetch(`${domain}/api/manager-reimbursements?status=Pending`)
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

    let reimbTableBody = document.getElementById("reimb-table-body");
    reimbTableBody.innerHTML = ``;

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    
    reimbTableBody.innerHTML += `        
            <tr>
                <td>${reimbList.reimbId}</td>
                <td>${reimbList.reimbAmount}</td>
                <td>${reimbList.reimbSubmitted}</td>
                <td>${reimbList.reimbResolved}</td>
                <td>${reimbList.reimbDescription}</td>
                <td>${reimbList.reimbReceipt}</td>
                <td>${reimbList.reimbAuthor}</td>
                <td>${reimbList.reimbResolver}</td>
                <td>${reimbList.reimbStatus}</td>
                <td>${reimbList.reimbType}</td>
            </tr>    
    `;

    })
}

//approve button filter
let approvedBtn = document.getElementById("approved-reimb");
approvedBtn.onclick = async function(e){
    e.preventDefault;

    const reimbListResponse = await fetch(`${domain}/api/manager-reimbursements?status=Approved`)
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

    let reimbTableBody = document.getElementById("reimb-table-body");
    reimbTableBody.innerHTML = ``;

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    
    reimbTableBody.innerHTML += `        
            <tr>
                <td>${reimbList.reimbId}</td>
                <td>${reimbList.reimbAmount}</td>
                <td>${reimbList.reimbSubmitted}</td>
                <td>${reimbList.reimbResolved}</td>
                <td>${reimbList.reimbDescription}</td>
                <td>${reimbList.reimbReceipt}</td>
                <td>${reimbList.reimbAuthor}</td>
                <td>${reimbList.reimbResolver}</td>
                <td>${reimbList.reimbStatus}</td>
                <td>${reimbList.reimbType}</td>
            </tr>    
    `;
    })
}

//denied button filter
let deniedBtn = document.getElementById("denied-reimb");
deniedBtn.onclick = async function(e){
    e.preventDefault;

    const reimbListResponse = await fetch(`${domain}/api/manager-reimbursements?status=Denied`)
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

    let reimbTableBody = document.getElementById("reimb-table-body");
    reimbTableBody.innerHTML = ``;

    reimbListData.data.forEach(reimbList =>{
        console.log(reimbList);

    
    reimbTableBody.innerHTML += `        
            <tr>
                <td>${reimbList.reimbId}</td>
                <td>${reimbList.reimbAmount}</td>
                <td>${reimbList.reimbSubmitted}</td>
                <td>${reimbList.reimbResolved}</td>
                <td>${reimbList.reimbDescription}</td>
                <td>${reimbList.reimbReceipt}</td>
                <td>${reimbList.reimbAuthor}</td>
                <td>${reimbList.reimbResolver}</td>
                <td>${reimbList.reimbStatus}</td>
                <td>${reimbList.reimbType}</td>
            </tr>    
    `;
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

let resolveReimbForm = document.getElementById("resolve-reimb-form");

let approveReimb = document.getElementById("approve-reimb");
let denyReimb = document.getElementById("deny-reimb");

approveReimb.onclick = async function(e){
    e.preventDefault();

    let reimbResolveInput = document.getElementById("reimb-resolve-input").value;
    /* let reimbResolver = usersId; */
    
    if(reimbResolveInput != null){
        let approveReimbRes = await fetch(`${domain}/api/manager-reimbursements`, {
            method: "PATCH",
            body: JSON.stringify({
                reimbResolver: usersId,
                reimbStatusId: 2,
                reimbId: reimbResolveInput
            })
        })

        let approveReimbResData = await approveReimbRes.json();

        if(approveReimbResData.success){
            window.location = `${domain}/manager-reimbursements?usersId=${usersId}`
        }
    }
}

denyReimb.onclick = async function(e){
    e.preventDefault();

    let reimbResolveInput = document.getElementById("reimb-resolve-input").value;

    if(reimbResolveInput != null){
        let denyReimbRes = await fetch(`${domain}/api/manager-reimbursements`, {
            method: "PATCH",
            body: JSON.stringify({
                reimbResolver: usersId,
                reimbStatusId: 3,
                reimbId: reimbResolveInput
            })
        })

        let denyReimbResData = await denyReimbRes.json();

        if(denyReimbResData.success){
            window.location = `${domain}/manager-reimbursements?usersId=${usersId}`
        }
    }
}

