using System;
using System.Collections.Generic;
using System.Linq;
using System.Net;
using System.Net.Http;
using System.Web.Http;
using WebApplication1.Models;

namespace WebApplication1.Controllers
{
    public class StudentController : ApiController
    {
        List<Student> students = new List<Student>();

        // CONSTRUCTOR
        public StudentController()
        {
            students.Add(new Student { FirstName = "Logan", LastName = "Campbell", IdNumber = "#########", MajorStudy = "CSCE" });
        }
        // GET: api/Student
        public List<Student> Get()
        {
            return students;
        }

        // GET: api/Student/5
        public Student Get(string idnumber)
        {
            return students.Where(x => x.IdNumber == idnumber).FirstOrDefault();

        }

        // POST: api/Student
        public void Post(Student val)
        {
            students.Add(val);
        }

        // PUT: api/Student/5
        public void Put(int id, [FromBody]string value)
        {
        }

        // DELETE: api/Student/5
        public void Delete(int id)
        {
        }



        [Route("api/Student/majorstudies")]
        [HttpGet]
        public List<string> GetMajorStudies()
        {
            List<string> gms = new List<string>();
            foreach (var p in students)
            {
                gms.Add(p.MajorStudy);
            }
            return gms;
        }

    }
}
