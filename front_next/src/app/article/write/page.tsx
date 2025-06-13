"use client";

import { useEffect, useRef } from "react";
import EditorJS from "@editorjs/editorjs";

export default function WritePage() {
  const editorRef = useRef<EditorJS | null>(null);

  useEffect(() => {
    if (!editorRef.current) {
      const editor = new EditorJS({
        holder: "editorjs",
        autofocus: true,
        tools: {
          header: require("@editorjs/header"),
          checklist: require("@editorjs/checklist"),
          list: require("@editorjs/list"),
          code: require("@editorjs/code"),
        },
        onReady: () => {
          editorRef.current = editor;
        },
        placeholder: "여기에 글을 작성하세요...",
      });
    }

    return () => {
      editorRef.current?.destroy();
      editorRef.current = null;
    };
  }, []);

  const handleSave = async () => {
    const output = await editorRef.current?.save();
    console.log("📝 저장된 데이터:", output);
  };

  return (
    <div className="p-10 max-w-4xl mx-auto">
      <h1 className="text-2xl font-bold mb-6">📝 게시글 작성</h1>
      <div
        id="editorjs"
        className="border border-gray-300 rounded-md p-4 min-h-[400px]"
      />
      <button
        onClick={handleSave}
        className="mt-6 px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
      >
        저장하기
      </button>
    </div>
  );
}
