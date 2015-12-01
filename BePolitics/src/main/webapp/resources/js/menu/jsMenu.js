$(function() {
	var Accordion = function(el, multiple) {
		this.el = el || {};
		this.multiple = multiple || false;
		//console.log('');
		// Variables privadas
		var links = this.el.find('.link');
		//Evento
		links.on('click', {el: this.el, multiple: this.multiple},this.dropdown);
	}
	Accordion.prototype.dropdown = function(e){
		//console.log('clickeando...');
		var $el = e.data.el;
			$this = $(this),
			$next = $this.next(); //submenu

		$next.slideToggle();
		
		$this.parent().toggleClass('open');//padre (li)

		//para que se muestren solo los elementos de un submenu
		if(!e.data.multiple){
			$el.find('.submenu').not($next).slideUp().removeClass('open');
		};

	}

	var accordion = new Accordion($('#accordion'));
	//si se desea mostrar varios submenus a la vez....
	//var accordion = new Accordion($('#accordion'), true);
});
