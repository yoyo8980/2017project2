window.addEventListener("load", function(){
		
		var mktweb = document.querySelector("#mktweb");
		var lmsweb = document.querySelector("#lmsweb");
		
		document.getElementById("wrapper").style.width="70%";
       document.getElementById("wrapper").style.float="left" ;
        document.getElementById("padding").style.marginLeft="0px";
        document.getElementById("content").style.marginTop="200px";
        
        lmsweb.style.width="30%";
        lmsweb.style.marginLeft= "1300px";
        lmsweb.style.float="right";
        lmsweb.style.borderLeft="3px double gray";
        lmsweb.style.height="900px";
        
		lmsweb.addEventListener("mouseover", function(){
			mktweb.style.opacity="0.3";
			lmsweb.style.opacity="1";
			lmsweb.addEventListener("mouseout", function(){
				mktweb.style.opacity="1";
				lmsweb.style.opacity="0.3";
			});
		});
	});