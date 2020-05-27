
        /*存储到本地*/
//        // 文件保存的命名空间
//        String fileSpace = "g:/wd";
//        // 保存到数据库中的相对路径
//        String uploadPathDB = "/" + userId + "/face";
//
//        // 文件上传的最终保存路径
//        String finalFacePath = fileSpace + uploadPathDB + "/" + fileName;
//        // 设置数据库保存的路径
//        uploadPathDB += ("/" + fileName);
//
//        File outFile = new File(finalFacePath);
//        if (outFile.getParentFile() != null && !outFile.getParentFile().isDirectory()) {
//            // 创建父文件夹
//            outFile.getParentFile().mkdirs();
//        }
//        try {
//            file.transferTo(new File(finalFacePath));
//        } catch (IOException e) {
//            log.error(e.toString());
//            throw new ApiException(ResultEnum.ERROR_CHANGEFACE);
//        }