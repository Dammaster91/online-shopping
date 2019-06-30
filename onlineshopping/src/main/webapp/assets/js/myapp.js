$(function(){
	
	switch(menu){
	
	case 'Abouts Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	default:
		$('#home').addClass('active');
		break;
		
	}
});