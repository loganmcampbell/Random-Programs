
function mov()
{
  var element = document.getElementById("box");
  var x = 0; var y = 0;
  var reverse = false; var location = setInterval(frame, 10);
  var pixel = 'px'; var bound = '440px'; var zero  = '0px';
  var loop = true;
  function frame()
  {
        if ((element.style.top != bound) && (reverse == false))
        {
          x++;
          element.style.top = x + pixel;
        }
        if ((element.style.top == bound) && (element.style.left != bound) && (reverse == false))
        {
          y++;
          element.style.left = y + pixel;
        }
        if ((element.style.top == bound) && (element.style.left == bound))
        {
          reverse = true;
        }
        if ((reverse == true) && (element.style.top != zero) && (element.style.left == bound))
        {
          x--;
          element.style.top = x + pixel;
        }
        if ((reverse == true) && (element.style.top == zero) && (element.style.left != zero))
        {
          y--;
          element.style.left = y + pixel;
        }
        if ((reverse == true) && (element.style.top == zero) && (element.style.left == zero))
        {
          reverse = false;
        }
  }

}
