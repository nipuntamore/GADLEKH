public class Fort {
    private String Name, District, Description, File_path;
    Fort(String Name, String District, String Description, String File_path){
        this.Name = Name;
        this.District = District;
        this.Description = Description;
        this.File_path = File_path;
    }

    public String getName(){
        return Name;
    }
    public String getDistrict(){
        return District;
    }
    public String getDescription(){
        return Description;
    }
    public String getFile_path(){
        return File_path;
    }

}
