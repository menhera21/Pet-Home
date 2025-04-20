import request from '@/utils/request'

// 查询房间信息列表
export function listInfo(query) {
  return request({
    url: '/system/roomInfo/list',
    method: 'get',
    params: query
  })
}

// 查询房间信息详细
export function getInfo(roomId) {
  return request({
    url: '/system/roomInfo/' + roomId,
    method: 'get'
  })
}

// 新增房间信息
export function addInfo(data) {
  return request({
    url: '/system/roomInfo',
    method: 'post',
    data: data
  })
}

// 修改房间信息
export function updateInfo(data) {
  return request({
    url: '/system/roomInfo',
    method: 'put',
    data: data
  })
}

// 删除房间信息
export function delInfo(roomId) {
  return request({
    url: '/system/roomInfo/' + roomId,
    method: 'delete'
  })
}
